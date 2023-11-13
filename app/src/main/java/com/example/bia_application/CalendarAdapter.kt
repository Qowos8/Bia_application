package com.example.bia_application

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.applandeo.materialcalendarview.listeners.OnDayClickListener

class CalendarAdapter(
    private val context: Context,
    private val days: List<Int>,
    private val onDayClickListener: OnDayClickListener
) : BaseAdapter() {

    override fun getCount(): Int {
        return days.size
    }

    override fun getItem(position: Int): Any {
        return days[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        TODO("Not yet implemented")
    }

    //@SuppressLint("ServiceCast", "ViewHolder")
    /*override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val day = getItem(position)
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val viewWork = inflater.inflate(R.layout.calendar_cell_work, null)
        val viewChill = inflater.inflate(R.layout.calendar_cell_chill, null)
        val viewRest = inflater.inflate(R.layout.calendar_cell_rest, null)
        val viewWeak = inflater.inflate(R.layout.calendar_cell_rest, null)

        val cell = view.findViewById<ConstraintLayout>(R.id.container)
        //cell.setBackgroundColor(getCellColor(day))

        view.setOnClickListener {
        //    onDayClickListener.onDayClick(day)
        }

        return view
    }*/

    /*private fun getCellColor(day: Int): Int {

        return when {
            (day % 2 == 0) ->  ContextCompat.getColor(context, R.color.day_month_work)
            DayState.CHILL -> ContextCompat.getColor(context, R.color.day_month_chill)

            else -> ContextCompat.getColor(context, R.color.white)
        }
    }*/
}

