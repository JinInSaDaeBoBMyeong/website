package android.support.v4.view;
public class ViewConfigurationCompat {
    static final android.support.v4.view.ViewConfigurationCompat$ViewConfigurationVersionImpl IMPL;

    static ViewConfigurationCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 11) {
            android.support.v4.view.ViewConfigurationCompat.IMPL = new android.support.v4.view.ViewConfigurationCompat$BaseViewConfigurationVersionImpl();
        } else {
            android.support.v4.view.ViewConfigurationCompat.IMPL = new android.support.v4.view.ViewConfigurationCompat$FroyoViewConfigurationVersionImpl();
        }
        return;
    }

    public ViewConfigurationCompat()
    {
        return;
    }

    public static int getScaledPagingTouchSlop(android.view.ViewConfiguration p1)
    {
        return android.support.v4.view.ViewConfigurationCompat.IMPL.getScaledPagingTouchSlop(p1);
    }
}
