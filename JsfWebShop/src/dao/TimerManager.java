package dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Singleton
@Startup
public class TimerManager {
	@Resource
	private TimerService timerService;

	static Map<String, TimerInterface> beans = new HashMap<String, TimerInterface>();

	@PostConstruct
	public void initTimer() {
		if (timerService.getTimers() != null) {
			for (Timer timer : timerService.getTimers()) {
				if (timer.getInfo().toString().startsWith("CarrinhoDao"))
					timer.cancel();
			}
			timerService.createCalendarTimer(new ScheduleExpression().hour("*")
					.minute("*/1"), new TimerConfig("CarrinhoDao", true));
		}
	}

	public synchronized void register(String id, TimerInterface ref) {
		System.out.println("register:" + id + ", " + ref);
		if (!beans.containsKey(id)) {
			beans.put(id, ref);
		}
	}

	public synchronized void unregister(String id) {
		if (beans.containsKey(id)) {
			System.out.println("unregister:" + id);
			beans.remove(id);
		}
	}

	@Timeout
	public synchronized void ejbTimeout(Timer timer) {
		System.out.println("Timer tick:" + new Date());
		for (String id : beans.keySet()) {
			System.out.println("Carrinho expirado: " + id);
			beans.get(id).avisa(timer, id);
		}
	}
}
