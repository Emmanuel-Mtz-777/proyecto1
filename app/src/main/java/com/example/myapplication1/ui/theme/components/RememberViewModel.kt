package com.example.myapplication1.ui.theme.components

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.myapplication1.ui.theme.components.Reminder
import com.example.myapplication1.ui.theme.components.NotificationWorker
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class ReminderViewModel : ViewModel() {
    private val _reminders = MutableStateFlow<List<Reminder>>(emptyList())
    val reminders: StateFlow<List<Reminder>> = _reminders

    fun addReminder(
        context: Context,
        title: String,
        description: String,
        dateTime: Long
    ) {
        viewModelScope.launch {
            val newReminder = Reminder(
                id = _reminders.value.size + 1,
                title = title,
                description = description,
                dateTime = dateTime
            )
            _reminders.value = _reminders.value + newReminder

            scheduleNotification(context, newReminder)
        }
    }

    private fun scheduleNotification(context: Context, reminder: Reminder) {
        val workManager = WorkManager.getInstance(context)

        // Crear los datos para la notificación
        val inputData = workDataOf(
            NotificationWorker.KEY_TITLE to reminder.title,
            NotificationWorker.KEY_DESCRIPTION to reminder.description
        )

        // Calcular el delay hasta la fecha del recordatorio
        val currentTime = System.currentTimeMillis()
        val delayInMillis = reminder.dateTime - currentTime

        // Crear la solicitud de chamba
        val notificationWork = OneTimeWorkRequestBuilder<NotificationWorker>()
            .setInputData(inputData)
            .setInitialDelay(delayInMillis, TimeUnit.MILLISECONDS)
            .build()

        // Programar la chamba
        workManager.enqueueUniqueWork(
            "reminder_${reminder.id}",
            ExistingWorkPolicy.REPLACE,
            notificationWork
        )
    }

    fun deleteReminder(context: Context, reminder: Reminder) {
        viewModelScope.launch {
            _reminders.value = _reminders.value.filter { it.id != reminder.id }

            // Cancelar la notificación programada
            WorkManager.getInstance(context)
                .cancelUniqueWork("reminder_${reminder.id}")
        }
    }
}
