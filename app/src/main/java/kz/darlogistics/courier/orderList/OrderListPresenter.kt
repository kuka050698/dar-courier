package kz.darlogistics.courier.orderList

import kz.darlogistics.courier.core.util.BasePresenter
import kz.darlogistics.courier.orderList.entity.Data
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class OrderListPresenter: BasePresenter<OrderListContract.OrderListView>(),OrderListContract.OrderListPresenter,KoinComponent{
    val orderListRepository:OrderListContract.OrderListRepository by inject()
    override fun getCurrentOrders() {
        orderListRepository.getCurrentOrders(207,"bearer hgGpX7kyYQLGt1uXCtR3V4nMS7KxfuVUkRGf7dOhGGpwOTJvyX2EeUCeRJjY")
                .subscribe{
                    var orders = ArrayList<Data>()
                    for (order in it.data){
                        orders.add(order)
                    }
                    getView()?.showOrderList(orders)
                }
    }

    override fun getNewOrders() {
        orderListRepository.getNewOrders(207)
                .subscribe{
                    var orders = ArrayList<Data>()
                    for (order in it.data){
                        orders.add(order)
                    }
                    getView()?.showOrderList(orders)
                }
    }

    override fun getHistoryOrders() {
        orderListRepository.getHistoryOrders(207)
                .subscribe{
                    var orders = ArrayList<Data>()
                    for (order in it.data){
                        orders.add(order)
                    }
                    getView()?.showOrderList(orders)
                }
    }

    override fun getRefundsOrders() {
        orderListRepository.getRefundsOrders(207,"bearer hgGpX7kyYQLGt1uXCtR3V4nMS7KxfuVUkRGf7dOhGGpwOTJvyX2EeUCeRJjY")
                .subscribe{
                    var orders = ArrayList<Data>()
                    for (order in it.data){
                        orders.add(order)
                    }
                    getView()?.showOrderList(orders)
                }
    }
    override fun getUpdatedCurrentOrders() {
        orderListRepository.getCurrentOrders(207,"bearer hgGpX7kyYQLGt1uXCtR3V4nMS7KxfuVUkRGf7dOhGGpwOTJvyX2EeUCeRJjY")
                .subscribe{
                    var orders = ArrayList<Data>()
                    for (order in it.data){
                        orders.add(order)
                    }
                    getView()?.updateOrderList(orders)
                }
    }

    override fun getUpdatedNewOrders() {
        orderListRepository.getNewOrders(207)
                .subscribe{
                    var orders = ArrayList<Data>()
                    for (order in it.data){
                        orders.add(order)
                    }
                    getView()?.updateOrderList(orders)
                }
    }

    override fun getUpdateHistoryOrders() {
        orderListRepository.getHistoryOrders(207)
                .subscribe{
                    var orders = ArrayList<Data>()
                    for (order in it.data){
                        orders.add(order)
                    }
                    getView()?.updateOrderList(orders)
                }
    }

    override fun getUpdateRefundsOrders() {
        orderListRepository.getRefundsOrders(207,"bearer hgGpX7kyYQLGt1uXCtR3V4nMS7KxfuVUkRGf7dOhGGpwOTJvyX2EeUCeRJjY")
                .subscribe{
                    var orders = ArrayList<Data>()
                    for (order in it.data){
                        orders.add(order)
                    }
                    getView()?.updateOrderList(orders)
                }
    }
    override fun viewIsReady() {

    }

    override fun destroy() {

    }

}