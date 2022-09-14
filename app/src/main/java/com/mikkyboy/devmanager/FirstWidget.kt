package com.mikkyboy.devmanager

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RemoteViews
import com.google.assistant.appactions.widgets.AppActionsWidgetExtension

/**
 * Implementation of App Widget functionality.
 */
class FirstWidget : AppWidgetProvider() {
    public val TAG = "DevManager"
    public var KEY = ""
    public var NAME = ""

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        logIntent(Intent.getIntentOld(""))
//        val i = getIntent()

        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    fun logIntent(intent: Intent) {
        Log.d(TAG, "======= Widget LOG========= %s")

        val bundle: Bundle = intent.extras ?: return

        Log.d(TAG, "======= logIntent ========= %s")
        Log.d(TAG, "Logging intent data start")

        bundle.keySet().forEach { key ->
            Log.d("YO", "[$key=${bundle.get(key)}]")
            KEY = bundle.keySet().first()
            NAME = "${bundle.get(bundle.keySet().first())}"
            println("LOL => $KEY")
            println("LOL => $NAME")
        }

        Log.d(TAG, "Logging intent data complete")
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    // AppActionsWidgetExtension
    val optionsBundle: Bundle = appWidgetManager.getAppWidgetOptions(appWidgetId)
    val bii: String = optionsBundle.getString(AppActionsWidgetExtension.EXTRA_APP_ACTIONS_BII) ?: ""
    val params: Bundle? =
        optionsBundle.getBundle(AppActionsWidgetExtension.EXTRA_APP_ACTIONS_PARAMS)

    if (params != null && params.containsKey(("name"))) {
        val orderName: String? = params.getString("name")
        println("ORDER NAME => $orderName")
        println("BII => $bii")
        println("PARAMS => $params")
    } else {
        println("ORDER NAME => EMPTY")
        println("BII => ${AppActionsWidgetExtension.EXTRA_APP_ACTIONS_BII}")
        println("BII => $bii")
        println("PARAMS => $params")
    }

    println("<==== YO ====>")


    optionsBundle.keySet().forEach { key ->
        Log.d("YO", "[$key=${optionsBundle.get(key)}]")
        FirstWidget().KEY = optionsBundle.keySet().first()
        FirstWidget().NAME = "${optionsBundle.get(optionsBundle.keySet().first())}"
        println("LOL KEY => $key")
        println("LOL => ${FirstWidget().KEY}")
        println("LOL => ${FirstWidget().NAME}")

        var myBundle: Bundle = optionsBundle.get("app_actions_params") as Bundle
        println("=======> ParamBundle <==")
        val paramKey: String = myBundle.keySet().first()
        println("ParamKey => $paramKey")
        val paramName : String = myBundle.get(paramKey) as String
        println("ParamName => $paramName")

    }
    // AppActionsWidgetExtension

    val widgetText = context.getString(R.string.appwidget_text)
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.first_widget)
    views.setTextViewText(R.id.appwidget_text, widgetText)

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)


}

