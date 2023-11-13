package com.example.bia_application

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.applandeo.materialcalendarview.CalendarView
import java.util.Calendar


class Chart_fragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.chart, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendarView = view.findViewById<CalendarView>(R.id.calendar)
        //val customAdapter = CalendarAdapter(requireContext(), yourListOfDays, yourOnDayClickListener)
        //calendarView.setAdapter(customAdapter)

        //val selectedDates: List<Calendar> = calendarView.getSelectedDates()

        //val calendar = view.findViewById<CalendarView>(R.id.calendar)
        //val currentLocale = resources.configuration.locale

        //val monthLabels = resources.getStringArray(R.array.material_calendar_months_array)
        //val dayLabels = resources.getStringArray(R.array.custom_weekdays)

        //calendar.Mon     monthLabels
        //calendar.dayLabels = dayLabels
    }
}