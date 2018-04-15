# Android RecyclerView 控件使用
Android RecyclerView 控件详细使用方法及代码示例，以及RecyclerView分割线悔之类封装。

## 更新RecyclerView分割线绘制类
> 1.增加可以设置水平风向和垂直方方向的分割线的宽度和颜色以及交叉点点的颜色
> 2.增加动态指定是否需要绘制四周(第一行之前、最后一行之后、第一列之前、最后一列之后)的分割线
> 3.增加分别指定四周分割线的宽度和颜色以及交叉点的颜色

**具体方法**
1.指定水平方向的垂直方向的分割线宽
* dividerHeight(int dividerHeight)
* dividerHeight(int horizontalDividerHeight, int verticalDividerHeight)

2.指定水平方向的垂直方向的分割线颜色以及交叉点颜色
* dividerColor(int dividerColor)
* dividerColor(int horizontalDividerColor, int verticalDividerColor)
* dividerColor(int horizontalDividerColor, int verticalDividerColor, int crossPointColor)

3.指定是否需要绘制四周分割线以及设置相关属性

指定是否需要绘制第一行之前的分割线以及设置相关属性
* isDrawFirstLowBefore(boolean isDrawFirstLow)
* isDrawFirstLowBeforeColor(boolean isDrawFirstLow, int firstLowColor)
* isDrawFirstLowBeforeHeight(boolean isDrawFirstLow, int firstLowHeight)
* isDrawFirstLowBefore(boolean isDrawFirstLow, int firstLowColor, int firstLowHeight)

指定是否需要绘制第一列之前的分割线以及设置相关属性
* isDrawFirstColBefore(boolean isDrawFirstCol)
* isDrawFirstColBeforeColor(boolean isDrawFirstCol, int firstColColor)
* isDrawFirstColBeforeHeight(boolean isDrawFirstCol, int firstColHeight)
* isDrawFirstColBefore(boolean isDrawFirstCol, int firstColColor, int firstColHeight)

指定是否需要绘制最后一行之后的分割线以及设置相关属性
* isDrawLastLowAfter(boolean isDrawLastLow)
* isDrawLastLowAfterColor(boolean isDrawLastLow, int lastLowColor)
* isDrawLastLowAfterHeight(boolean isDrawLastLow, int lastLowHeight)
* isDrawLastLowAfter(boolean isDrawLastLow, int lastLowColor, int lastLowHeight)

指定是否需要绘制最后一列之后的分割线以及设置相关属性
* isDrawLastColAfter(boolean isDrawLastCol)
* isDrawLastColAfterColor(boolean isDrawLastCol, int lastColColor)
* isDrawLastColAfterHeight(boolean isDrawLastCol, int lastColHeight)
* isDrawLastColAfter(boolean isDrawLastCol, int lastColColor, int lastColHeight)

---
## 更新(新增自定义下拉刷新和加载更多效果)
扩展`RecyclerView`控件，实现自定义下拉刷新和加载更多效果，控件名：RefreshRecyclerView
> 在布局文件中定义

	<com.android.recyclerviewtest.view.RefreshRecyclerView
        android:id="@+id/recyclerview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
> 在代码中找到控件，然后设置监听

	RefreshRecyclerView recyclerview = (RefreshRecyclerView) findViewById(R.id.recyclerview);
	// 刷新监听
        recyclerview.setOnRefreshListener(new RefreshRecyclerView.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
        // 加载更多监听
        recyclerview.setOnLoadMoreListener(new RefreshRecyclerView.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {

            }
        });
> 设置能否刷新或者加载更多

	recyclerview.setCanLoadMore(false); // 设置能否加载更多
    recyclerview.setCanRefresh(false);  // 设置能否刷新
> 设置是否还有更多

	recyclerview.setHasMore(true);

---
## 主要包含的代码示例
> 1.使用不同的RecyclerView.LayoutManger实现不同风格的布局(ListView类型、GridView类型、瀑布流类型)  
> 2.给RecyclerView添加分割线  
> 3.给 item 添加点击事件和长按事件  
> 4.使用 GridLayoutManager 指定item占用列数、使用多种 item 类型  
> 5.与 SwipeRefreshLayout 控件结合实现刷新和自动加载更多  
> 6.使用 ItemTouchHelper 实现拖拽和侧滑删除效果  
> 7.将Adapter进行的简单的封装

	SingleTypeAdapter<T> 类：只有一种 item 类型时的RecyclerView.Adapter
	MultipleTypeAdapter<T> 类：有多种 item 类型时的 RecyclerView.Adapter
	CustomViewHolder 类：继承至 RecyclerView.ViewHolder 的自定义 ViewHolder

博客说明地址：<http://blog.csdn.net/itrenj/article/details/70163238>
## 效果图
![RecyclerView效果图目录](https://github.com/itrenjunhua/RecyclerViewTest/raw/master/images/image1.png)   ![RecyclerView列表效果](https://github.com/itrenjunhua/RecyclerViewTest/raw/master/images/image2.gif)  ![RecyclerView效果图网格效果](https://github.com/itrenjunhua/RecyclerViewTest/raw/master/images/image3.gif)   ![RecyclerView效果图瀑布流效果](https://github.com/itrenjunhua/RecyclerViewTest/raw/master/images/image4.gif)   ![RecyclerView效果图活用网格布局效果](https://github.com/itrenjunhua/RecyclerViewTest/raw/master/images/image5.gif)   ![RecyclerView效果图多种item效果](https://github.com/itrenjunhua/RecyclerViewTest/raw/master/images/image6.gif)   ![RecyclerView效果图刷新加载效果](https://github.com/itrenjunhua/RecyclerViewTest/raw/master/images/image7.gif)   ![RecyclerView效果图拖拽和侧滑效果](https://github.com/itrenjunhua/RecyclerViewTest/raw/master/images/image8.gif)
