package dao;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
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
	@EJB
	private CarrinhoDao dao;
	private static boolean isRunning = false;

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

	@Timeout
	public synchronized void ejbTimeout(Timer timer) {
		if (!isRunning) {
			System.out.println("Timer tick:" + new Date());
			isRunning = true;

			((TimerInterface) dao).avisa(timer);
			isRunning = false;
		}
	}
}
