package com.ternaryop.materialdrawerselectedbadge

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.holder.BadgeStyle
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem

class MainActivity : AppCompatActivity() {
    private lateinit var drawer: Drawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawer = drawerBuilder(this)
            .withToolbar(toolbar)
            .build()
    }

    private fun drawerBuilder(activity: Activity): DrawerBuilder {
        val draft = PrimaryDrawerItem()
            .withName("draft")
            .withIdentifier(2)
            .withBadge("10")
            .withBadgeStyle(getCountBadgeStyle(activity))
        val schedule = PrimaryDrawerItem()
            .withName("schedule")
            .withIdentifier(3)
            .withBadge("40")
            .withBadgeStyle(getCountBadgeStyle(activity))
        val birthdaysBrowserTitle = PrimaryDrawerItem()
            .withIdentifier(7).withName("publish")

        return DrawerBuilder()
            .withActivity(activity)
            .addDrawerItems(
                draft,
                schedule,
                birthdaysBrowserTitle
            )
            .withShowDrawerOnFirstLaunch(true)
    }

    private fun getCountBadgeStyle(context: Context): BadgeStyle {
        return BadgeStyle()
            .withTextColorStateList(context.getColorStateList(R.color.drawer_counter_text_selector))
            .withBadgeBackground(checkNotNull(context.getDrawable(R.drawable.drawer_counter_bg_selector)))
    }

}
