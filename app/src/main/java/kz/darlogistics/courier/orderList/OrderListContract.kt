package kz.darlogistics.courier.orderList

import io.reactivex.Observable
import kz.darlogistics.courier.core.util.IPresenter
import kz.darlogistics.courier.core.util.IView
import kz.darlogistics.courier.orderList.entity.Data
import kz.darlogistics.courier.orderList.entity.Orders

interface OrderListContract {
    interface OrderListView : IView<OrderListPresenter> {
        fun showOrderList(orders:ArrayList<Data>)
        fun updateOrderList(orders:ArrayList<Data>)
    }

    interface OrderListPresenter : IPresenter<OrderListContract.OrderListView> {
        fun getCurrentOrders()
        fun getNewOrders()
        fun getHistoryOrders()
        fun getRefundsOrders()
        fun getUpdatedCurrentOrders()
        fun getUpdatedNewOrders()
        fun getUpdateHistoryOrders()
        fun getUpdateRefundsOrders()
    }

    interface OrderListRepository {
        fun getCurrentOrders(userId:Int,token:String): Observable<Orders>
        fun getNewOrders(userId:Int):Observable<Orders>
        fun getHistoryOrders(userId:Int):Observable<Orders>
        fun getRefundsOrders(userId:Int,token:String):Observable<Orders>
    }
}