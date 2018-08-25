package kz.darlogistics.courier.orderList

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_current_order_list.*

class NewOrderListFragment:BaseOrderListFragment(){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.getNewOrders()
        super.onViewCreated(view, savedInstanceState)
        swipeListOrder.setOnRefreshListener {
            presenter.getUpdatedNewOrders()
        }
    }
}