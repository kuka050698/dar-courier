package kz.darlogistics.courier.orderList
import android.support.v7.util.DiffUtil
import kz.darlogistics.courier.orderList.entity.Data

class OrderListDiffUtilCallback(var oldList:ArrayList<Data>,var newList:ArrayList<Data>): DiffUtil.Callback() {
    override fun areItemsTheSame(p0: Int, p1: Int): Boolean {
        return oldList[p0].id==newList[p1].id
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(p0: Int, p1: Int): Boolean {
        return oldList[p0].courier_id==newList[p1].courier_id && oldList[p0].active==newList[p1].active
    }
}