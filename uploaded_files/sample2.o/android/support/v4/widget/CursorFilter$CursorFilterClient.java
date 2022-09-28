package android.support.v4.widget;
interface CursorFilter$CursorFilterClient {

    public abstract void changeCursor();

    public abstract CharSequence convertToString();

    public abstract android.database.Cursor getCursor();

    public abstract android.database.Cursor runQueryOnBackgroundThread();
}
