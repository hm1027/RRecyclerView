package com.android.recyclerviewtest.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.recyclerviewtest.R;
import com.android.recyclerviewtest.adapter.ListGridAdapter;
import com.android.recyclerviewtest.adapter.SingleTypeAdapter;
import com.android.recyclerviewtest.data.DataUtil;
import com.android.recyclerviewtest.draw.CustomItemDecoration;
import com.android.recyclerviewtest.utils.RLog;
import com.android.recyclerviewtest.utils.ToastUtil;

import java.util.List;

/**
 * ======================================================================
 * <p/>
 * 作者：Renj
 * <p/>
 * 创建时间：2017-04-12    16:44
 * <p/>
 * 描述：垂直方向网格
 * <p/>
 * 修订历史：
 * <p/>
 * ======================================================================
 */

public class Grid1Activity extends BaseActivity {
    private TextView title;
    private RecyclerView recyclerView;
    private List<String> datas;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recycler_view;
    }

    @Override
    protected void initView() {
        title = (TextView) findViewById(R.id.title);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        title.setText("垂直方向网格（item 有点击事件）");

        datas = DataUtil.getTextData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        final ListGridAdapter adapter = new ListGridAdapter(this, datas, GridLayoutManager.VERTICAL);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        // 增加分割线
        recyclerView.addItemDecoration(new CustomItemDecoration().dividerHeight(40,(int) getResources().getDimension(R.dimen.line_height))
                .dividerColor(getResources().getColor(R.color.colorH),getResources().getColor(R.color.colorV),getResources().getColor(R.color.colorP))
        .isDrawLastLowAndCol(true,false)
        .isDrawFastLowAndCol(false,true));

        adapter.setOnItemClickListener(new SingleTypeAdapter.OnItemClickListener<String>() {
            @Override
            public void onItemClick(View itemView, int position, List<String> datas, String itemData) {
                RLog.i("点击 位置:" + position + "；数据:" + itemData);
                ToastUtil.showSingleToast(Grid1Activity.this, "点击 位置:" + position + "；数据:" + itemData);
            }
        });
    }
}
