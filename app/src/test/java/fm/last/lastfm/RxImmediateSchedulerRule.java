package fm.last.lastfm;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.concurrent.Callable;

import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

public class RxImmediateSchedulerRule implements TestRule {
    Function<Scheduler, Scheduler> trampoline = new Function<Scheduler, Scheduler>() {
        @Override
        public Scheduler apply(Scheduler scheduler) {
            return Schedulers.trampoline();
        }
    };
    Function<Callable<Scheduler>, Scheduler> trampolineCallable = new Function<Callable<Scheduler>, Scheduler>() {
        @Override
        public Scheduler apply(Callable<Scheduler> scheduler) {
            return Schedulers.trampoline();
        }
    };
    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                RxJavaPlugins.setIoSchedulerHandler(trampoline);
                RxJavaPlugins.setComputationSchedulerHandler(trampoline);
                RxJavaPlugins.setNewThreadSchedulerHandler(trampoline);
                RxAndroidPlugins.setInitMainThreadSchedulerHandler(trampolineCallable);

                try {
                    base.evaluate();
                } finally {
                    RxJavaPlugins.reset();
                    RxAndroidPlugins.reset();
                }
            }
        };
    }
}
