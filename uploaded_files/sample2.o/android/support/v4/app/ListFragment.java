package android.support.v4.app;
public class ListFragment extends android.support.v4.app.Fragment {
    static final int INTERNAL_EMPTY_ID = 16711681;
    static final int INTERNAL_LIST_CONTAINER_ID = 16711683;
    static final int INTERNAL_PROGRESS_CONTAINER_ID = 16711682;
    android.widget.ListAdapter mAdapter;
    CharSequence mEmptyText;
    android.view.View mEmptyView;
    private final android.os.Handler mHandler;
    android.widget.ListView mList;
    android.view.View mListContainer;
    boolean mListShown;
    private final android.widget.AdapterView$OnItemClickListener mOnClickListener;
    android.view.View mProgressContainer;
    private final Runnable mRequestFocus;
    android.widget.TextView mStandardEmptyView;

    public ListFragment()
    {
        this.mHandler = new android.os.Handler();
        this.mRequestFocus = new android.support.v4.app.ListFragment$1(this);
        this.mOnClickListener = new android.support.v4.app.ListFragment$2(this);
        return;
    }

    private void ensureList()
    {
        if (this.mList == null) {
            android.widget.ListView v2_0 = this.getView();
            if (v2_0 != null) {
                if (!(v2_0 instanceof android.widget.ListView)) {
                    this.mStandardEmptyView = ((android.widget.TextView) v2_0.findViewById(16711681));
                    if (this.mStandardEmptyView != null) {
                        this.mStandardEmptyView.setVisibility(8);
                    } else {
                        this.mEmptyView = v2_0.findViewById(16908292);
                    }
                    this.mProgressContainer = v2_0.findViewById(16711682);
                    this.mListContainer = v2_0.findViewById(16711683);
                    android.widget.ListView v1_0 = v2_0.findViewById(16908298);
                    if ((v1_0 instanceof android.widget.ListView)) {
                        this.mList = ((android.widget.ListView) v1_0);
                        if (this.mEmptyView == null) {
                            if (this.mEmptyText != null) {
                                this.mStandardEmptyView.setText(this.mEmptyText);
                                this.mList.setEmptyView(this.mStandardEmptyView);
                            }
                        } else {
                            this.mList.setEmptyView(this.mEmptyView);
                        }
                    } else {
                        if (v1_0 != null) {
                            throw new RuntimeException("Content has view with id attribute \'android.R.id.list\' that is not a ListView class");
                        } else {
                            throw new RuntimeException("Your content must have a ListView whose id attribute is \'android.R.id.list\'");
                        }
                    }
                } else {
                    this.mList = ((android.widget.ListView) v2_0);
                }
                this.mListShown = 1;
                this.mList.setOnItemClickListener(this.mOnClickListener);
                if (this.mAdapter == null) {
                    if (this.mProgressContainer != null) {
                        this.setListShown(0, 0);
                    }
                } else {
                    android.widget.ListAdapter v0 = this.mAdapter;
                    this.mAdapter = 0;
                    this.setListAdapter(v0);
                }
                this.mHandler.post(this.mRequestFocus);
            } else {
                throw new IllegalStateException("Content view not yet created");
            }
        }
        return;
    }

    private void setListShown(boolean p7, boolean p8)
    {
        this.ensureList();
        if (this.mProgressContainer != null) {
            if (this.mListShown != p7) {
                this.mListShown = p7;
                if (!p7) {
                    if (!p8) {
                        this.mProgressContainer.clearAnimation();
                        this.mListContainer.clearAnimation();
                    } else {
                        this.mProgressContainer.startAnimation(android.view.animation.AnimationUtils.loadAnimation(this.getActivity(), 17432576));
                        this.mListContainer.startAnimation(android.view.animation.AnimationUtils.loadAnimation(this.getActivity(), 17432577));
                    }
                    this.mProgressContainer.setVisibility(0);
                    this.mListContainer.setVisibility(8);
                } else {
                    if (!p8) {
                        this.mProgressContainer.clearAnimation();
                        this.mListContainer.clearAnimation();
                    } else {
                        this.mProgressContainer.startAnimation(android.view.animation.AnimationUtils.loadAnimation(this.getActivity(), 17432577));
                        this.mListContainer.startAnimation(android.view.animation.AnimationUtils.loadAnimation(this.getActivity(), 17432576));
                    }
                    this.mProgressContainer.setVisibility(8);
                    this.mListContainer.setVisibility(0);
                }
            }
            return;
        } else {
            throw new IllegalStateException("Can\'t be used with a custom content view");
        }
    }

    public android.widget.ListAdapter getListAdapter()
    {
        return this.mAdapter;
    }

    public android.widget.ListView getListView()
    {
        this.ensureList();
        return this.mList;
    }

    public long getSelectedItemId()
    {
        this.ensureList();
        return this.mList.getSelectedItemId();
    }

    public int getSelectedItemPosition()
    {
        this.ensureList();
        return this.mList.getSelectedItemPosition();
    }

    public android.view.View onCreateView(android.view.LayoutInflater p13, android.view.ViewGroup p14, android.os.Bundle p15)
    {
        android.support.v4.app.FragmentActivity v0 = this.getActivity();
        android.widget.FrameLayout v5_1 = new android.widget.FrameLayout(v0);
        android.widget.LinearLayout v3_1 = new android.widget.LinearLayout(v0);
        v3_1.setId(16711682);
        v3_1.setOrientation(1);
        v3_1.setVisibility(8);
        v3_1.setGravity(17);
        v3_1.addView(new android.widget.ProgressBar(v0, 0, 16842874), new android.widget.FrameLayout$LayoutParams(-2, -2));
        v5_1.addView(v3_1, new android.widget.FrameLayout$LayoutParams(-1, -1));
        android.widget.FrameLayout v1_1 = new android.widget.FrameLayout(v0);
        v1_1.setId(16711683);
        android.widget.TextView v6_1 = new android.widget.TextView(this.getActivity());
        v6_1.setId(16711681);
        v6_1.setGravity(17);
        v1_1.addView(v6_1, new android.widget.FrameLayout$LayoutParams(-1, -1));
        android.widget.ListView v2_1 = new android.widget.ListView(this.getActivity());
        v2_1.setId(16908298);
        v2_1.setDrawSelectorOnTop(0);
        v1_1.addView(v2_1, new android.widget.FrameLayout$LayoutParams(-1, -1));
        v5_1.addView(v1_1, new android.widget.FrameLayout$LayoutParams(-1, -1));
        v5_1.setLayoutParams(new android.widget.FrameLayout$LayoutParams(-1, -1));
        return v5_1;
    }

    public void onDestroyView()
    {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mList = 0;
        this.mListShown = 0;
        this.mListContainer = 0;
        this.mProgressContainer = 0;
        this.mEmptyView = 0;
        this.mStandardEmptyView = 0;
        super.onDestroyView();
        return;
    }

    public void onListItemClick(android.widget.ListView p1, android.view.View p2, int p3, long p4)
    {
        return;
    }

    public void onViewCreated(android.view.View p1, android.os.Bundle p2)
    {
        super.onViewCreated(p1, p2);
        this.ensureList();
        return;
    }

    public void setEmptyText(CharSequence p3)
    {
        this.ensureList();
        if (this.mStandardEmptyView != null) {
            this.mStandardEmptyView.setText(p3);
            if (this.mEmptyText == null) {
                this.mList.setEmptyView(this.mStandardEmptyView);
            }
            this.mEmptyText = p3;
            return;
        } else {
            throw new IllegalStateException("Can\'t be used with a custom content view");
        }
    }

    public void setListAdapter(android.widget.ListAdapter p5)
    {
        int v0;
        int v2 = 0;
        if (this.mAdapter == null) {
            v0 = 0;
        } else {
            v0 = 1;
        }
        this.mAdapter = p5;
        if (this.mList != null) {
            this.mList.setAdapter(p5);
            if ((!this.mListShown) && (v0 == 0)) {
                if (this.getView().getWindowToken() != null) {
                    v2 = 1;
                }
                this.setListShown(1, v2);
            }
        }
        return;
    }

    public void setListShown(boolean p2)
    {
        this.setListShown(p2, 1);
        return;
    }

    public void setListShownNoAnimation(boolean p2)
    {
        this.setListShown(p2, 0);
        return;
    }

    public void setSelection(int p2)
    {
        this.ensureList();
        this.mList.setSelection(p2);
        return;
    }
}
