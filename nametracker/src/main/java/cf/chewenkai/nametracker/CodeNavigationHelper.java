package cf.chewenkai.nametracker;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Print the name of current top Activity or Fragment's or the view you just clicked
 * using AOP
 * for reading and understanding source code rapidly.
 *
 * Example：
 *
 * 2018-11-06 16:00:07.605 20362-20362/tv.xiaodao.xdtv I/NameTracker: ➤ Where am I？ Activity:MainActivity
 * 2018-11-06 16:00:07.605 20362-20362/tv.xiaodao.xdtv I/NameTracker: ➤ Where am I？ Activity:MainActivity
 * 2018-11-06 16:00:07.605 20362-20362/tv.xiaodao.xdtv I/NameTracker: ➤ Where am I？ Activity:MainActivity
 * 2018-11-06 16:00:07.711 20362-20362/tv.xiaodao.xdtv I/NameTracker:         ➤ Where am I？ Fragment:HomeContainerFragment
 * 2018-11-06 16:00:08.215 20362-20362/tv.xiaodao.xdtv I/NameTracker:         ➤ Where am I？ Fragment:UserPageVideoFragment
 * 2018-11-06 16:00:08.257 20362-20362/tv.xiaodao.xdtv I/NameTracker:         ➤ Where am I？ Fragment:HomeHotFeedFragment
 * 2018-11-06 16:00:08.375 20362-20362/tv.xiaodao.xdtv I/NameTracker:         ➤ Where am I？ Fragment:MasterplateListFragment
 * 2018-11-06 16:01:53.516 20362-20362/tv.xiaodao.xdtv I/NameTracker:                 ☞What did I clicked？ You are in tv.xiaodao.xdtv.presentation.module.home.provider.CardItemProvider$ViewHolderCardItemProvider.java:486 and Clicked a View：View：android.support.v7.widget.AppCompatImageView{4a2d741 VFED..C.. ...P.... 0,0-135,135 #7f090140 app:id/item_card_avatar}
 * 2018-11-06 16:01:53.689 20362-20362/tv.xiaodao.xdtv I/NameTracker: ➤ Where am I？ Activity:FragmentZygoteActivity
 * 2018-11-06 16:01:53.689 20362-20362/tv.xiaodao.xdtv I/NameTracker: ➤ Where am I？ Activity:FragmentZygoteActivity
 * 2018-11-06 16:01:53.695 20362-20362/tv.xiaodao.xdtv I/NameTracker:         ➤ Where am I？ Fragment:UserProfileFragment
 * 2018-11-06 16:01:53.891 20362-20362/tv.xiaodao.xdtv I/NameTracker:         ➤ Where am I？ Fragment:UserPageGuestVideoFragment
 *
 * <p>
 * Created by calvinche
 * on 2018/11/6
 * Email: calvinche@tencent.com
 */
@Aspect
public class CodeNavigationHelper {
    private static final String TAG = "NameTracker";
    private static final String TAG_WHEREAMI = "Where am I？";
    private static final String TAG_WHATICLICK = "What did I clicked？";
    private static final String SPACE = "        ";

    @Before("execution(* *..Activity+.onResume(..))")
    public void whichActivity(JoinPoint joinPoint) throws Throwable {
            String className = joinPoint.getThis().getClass().getSimpleName();
            Log.i(TAG, "➤ " + TAG_WHEREAMI + " Activity:" + className);
    }

    @Before("execution(* *..Fragment+.onResume(..))")
    public void whichFragment(JoinPoint joinPoint) throws Throwable {

            String className = joinPoint.getThis().getClass().getSimpleName();
            Log.i(TAG, SPACE + "➤ " + TAG_WHEREAMI + " Fragment:" + className);

    }

    @After("execution(* android.view.View.OnClickListener.onClick(..))")
    public void whatClicked(JoinPoint joinPoint) throws Throwable {
            String className = joinPoint.getThis().getClass().getName();
            Log.i(TAG, SPACE + SPACE + "☞" + TAG_WHATICLICK
                    + " You are in " + className
                    + " ("+joinPoint.getSourceLocation()+")"
                    + " and Clicked a View：" + joinPoint.getArgs()[0].toString());
    }
}
