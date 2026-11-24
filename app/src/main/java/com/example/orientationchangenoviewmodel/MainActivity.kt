package com.example.orientationchangenoviewmodel

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.orientationchangenoviewmodel.ui.theme.OrientationChangeNoViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")

        enableEdgeToEdge()
        setContent {
            OrientationChangeNoViewModelTheme {
                val configuration = LocalConfiguration.current
                val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT


                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    if (isPortrait) {
                        PortraitLayout(innerPadding)
                    }
                    else {
                        LandScapeLayout(innerPadding)
                    }
                }

            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart called")
    }

    companion object {
        private const val TAG = "OrientationChangeNoViewModel"
    }

}

@Composable
fun PortraitLayout(paddingValues: PaddingValues) {
    var counter by remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxSize().padding(paddingValues))
    {
        Button(
            onClick =
                {
                    counter++
                }, Modifier.padding(all= 5.dp)
        ) {
            Text(text = stringResource(R.string.incCounter))
        }

        Text(modifier = Modifier.padding(all = 5.dp), text = stringResource(R.string.counterValue, counter))

    }
}


@Composable
fun LandScapeLayout(paddingValues: PaddingValues) {
    var counter by remember { mutableStateOf(0) }
    Column(Modifier.fillMaxSize().padding(paddingValues))
    {
        Row(verticalAlignment = Alignment.CenterVertically )
        {
            Button(
                onClick =
                    {
                        counter++
                    }, Modifier.padding(all = 5.dp)
            ) {
                Text(text = stringResource(R.string.incCounter))
            }

            Text(text = stringResource(R.string.counterValue, counter))
        }
    }
}