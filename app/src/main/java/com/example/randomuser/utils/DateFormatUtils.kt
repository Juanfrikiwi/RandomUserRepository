package com.example.randomuser.utils

import java.text.SimpleDateFormat
import java.util.Calendar

class DateFormatUtils {
    fun formatDateFromServer(dateString:String?):String{
        var dateFormatted = ""
        if (dateString != null){
            val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateString)
            val cal: Calendar = Calendar.getInstance()
            cal.time = date
            dateFormatted = SimpleDateFormat("dd/MM/yyyy").format(cal.time)
        }
        return dateFormatted
    }
}