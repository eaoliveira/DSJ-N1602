package com.example.unipharmus;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
                .findFragmentById(R.id.navigation_drawer);

        mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment;

        switch (position) {
            case 0:
                fragment = new TelaHOME();
                break;
            case 1:
                fragment = new TelaORCAMENTO();
                break;
            case 2:
                fragment = new TelaENTREGAR();
                break;
            case 3:
                fragment = new TelaQUEMSOMOS();
                break;
            case 4:
                fragment = new TelaCONTATO();
                break;
            case 5:
                fragment = new TelaREDESSOCIAIS();
                break;

            default:
                return;
        }

        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            getMenuInflater().inflate(R.menu.main, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.op_relatar:
                Intent irRELATAR = new Intent(this, TelaRelatar.class);
                startActivity(irRELATAR);
                break;
            case R.id.op_sobre:
                Intent irSOBRE = new Intent(this, TelaSobre.class);
                startActivity(irSOBRE);
                break;
            case R.id.op_logoff:
                new AsyncTask<Void, Void, Void>() {
                    private ProgressDialog pd;

                    @Override
                    protected void onPreExecute() {
                        pd = new ProgressDialog(MainActivity.this);
                        pd.setTitle("Fazendo logoff");
                        pd.setMessage("Aguarde ...");
                        pd.setIndeterminate(false);
                        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                       // pd.setMax(1000);
                        pd.show();
                    }

                    @Override
                    protected Void doInBackground(Void... voids) {
                        try {
                            for (int i = 0;!isCancelled() && i < 1000; i++) {
                                Thread.sleep(3000);
                                pd.setProgress(i);
                            }
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                            pd.setProgress(0);
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        pd.dismiss();
                    }

                    @Override
                    protected void onCancelled() {
                        pd.dismiss();
                    }
                }.execute();

//                final ProgressDialog pd = ProgressDialog.show(this,
//                        "Fazendo logoff", "Aguarde ...", true);
//                pd.setCancelable(true);
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Thread.sleep(10000);
//                        } catch (Exception e) {
//
//                        }
//                        pd.dismiss();
//                    }
//                }).start();
                Intent irLOGIN = new Intent(this, TelaLOGIN.class);
                startActivity(irLOGIN);
                break;
            case R.id.op_sair:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
