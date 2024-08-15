package com.example.modifierexemple

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.modifierexemple.ui.theme.ModifierExempleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModifierExempleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ModifierPropeties(innerPadding)
                }
            }
        }
    }
}

@Composable
fun ModifierPropeties(padding : PaddingValues){
    val cornerSize = 10.dp
    Box(modifier = Modifier
        .padding(padding)
        .fillMaxSize(), contentAlignment = Alignment.Center){
        TextField(value = "",
            onValueChange = {},
            modifier = Modifier
                .clickable {
                    Log.i("fake botao", "ModifierPropeties: O nosso botao fake foi clicado!!!")
                }
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(cornerSize))
                .clip(RoundedCornerShape(cornerSize))
                .width(200.dp)
                .padding(20.dp)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierPropetiesPreview(){
    ModifierPropeties(PaddingValues())
}