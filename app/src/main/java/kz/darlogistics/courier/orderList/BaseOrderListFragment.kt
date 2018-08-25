package kz.darlogistics.courier.orderList

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_current_order_list.*
import kz.darlogistics.courier.R
import kz.darlogistics.courier.orderList.entity.Data
import org.koin.android.ext.android.inject

abstract class BaseOrderListFragment:Fragment(),OrderListContract.OrderListView{
    override val presenter: OrderListContract.OrderListPresenter by inject()
    var orderListAdapter:OrderListAdapter?=null
    var orderList:RecyclerView?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_current_order_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.attachView(this)
        orderList = view.findViewById<RecyclerView>(R.id.orderList)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun showOrderList(orders: ArrayList<Data>) {
        orderList?.layoutManager= LinearLayoutManager(context)
        orderListAdapter = OrderListAdapter(orders)
        orderList?.adapter = orderListAdapter
    }
    override fun updateOrderList(orders: ArrayList<Data>) {
        val oldList = orderListAdapter?.orders
        val newList = orders
        var orderListDiffUtilCallback = OrderListDiffUtilCallback(oldList!!,newList)
        var difResult  = DiffUtil.calculateDiff(orderListDiffUtilCallback)
        orderListAdapter?.orders = orders
        difResult.dispatchUpdatesTo(orderListAdapter!!)
        swipeListOrder.isRefreshing=false
    }
}