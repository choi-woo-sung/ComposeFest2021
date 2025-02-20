package com.example.basiccodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccodelab.ui.theme.BasicCodeLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCodeLabTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }


//    @Composable
//    fun Greeting(name: String) {
//        val expanded = remember { mutableStateListOf(false)}
//        Surface(color = MaterialTheme.colors.primary) {
//            Row(modifier = Modifier.padding(24.dp)) {
//                Column(modifier = Modifier.weight(1f)) {
//                    Text(text = "Hello ")
//                    Text(text = "$name!")
//                }
//                OutlinedButton(onClick = { /*TODO*/ }) {
//                    Text(text = "Show More")
//                }
//            }
//        }
//    }


    @Composable
    fun Greeting(name: String) {
        var expanded by remember { mutableStateOf(false) }
//        val extraPadding = if (expanded.value) 48.dp else 0.dp

//        val extraPadding by animateDpAsState(
//            if (expanded) 48.dp else 0.dp,
//
//        )

        Card(
            backgroundColor =  MaterialTheme.colors.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Row(modifier = Modifier.padding(24.dp)) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(12.dp)
                        .animateContentSize(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessLow
                            )
                        )
                ) {
                    Text(text = "Hello ")
                    Text(
                        text = "$name!", style = MaterialTheme.typography.h4.copy(
                            fontWeight = FontWeight.ExtraBold
                        )
                    )
                    if (expanded) {
                        Text(
                            text = "아기 삼형제 여럿이 풀을뜯고 놀아요  아기 삼형제 여럿이 풀을뜯고 놀아요  아기 삼형제 여럿이 풀을뜯고 놀아요 " +
                                    " 아기 삼형제 여럿이 풀을뜯고 놀아요  아기 삼형제 여럿이 풀을뜯고 놀아요 "
                        )
                    }
                }
                IconButton(
                    onClick = {
                        expanded = !expanded
                    }) {
//                    Text(if (expanded.value) "Show less" else "Show more")
                    Icon(
                        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = if (expanded) getString(R.string.show_less) else getString(
                            R.string.show_more
                        )
                    )
                }
            }

        }
    }


    @Composable
    private fun Greetings(names: List<String> = List(1000) { "$it" }) {
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(items = names) { name ->
                Greeting(name = name)
            }
        }

    }

    @Preview(showBackground = true, name = "Text preview")
    @Composable
    fun DefaultPreview() {
        BasicCodeLabTheme {
            MyApp()
        }
    }

//    @Composable
//    private fun MyApp() {
//        Surface(color = MaterialTheme.colors.background){
//            Greeting("Android")
//        }
//    }

    @Composable
    private fun MyApp(
        names: List<String> = listOf("world", "Compose")
    ) {
        var shouldShowOnBoarding by rememberSaveable { mutableStateOf(true) }

        if (shouldShowOnBoarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnBoarding = false })
        } else {
//            Column {
//                for (name in names) {
//                    Greeting(name)
//                }
            Greetings()
        }
    }


    @Composable
    fun OnboardingScreen(onContinueClicked: () -> Unit) {


        Surface {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Welcome to the Basices Codelab ! ")
                Button(
                    modifier = Modifier.padding(vertical = 24.dp),
                    onClick = onContinueClicked
                ) {
                    Text("Continue")
                }
            }
        }
    }

    @Preview(showBackground = true, widthDp = 320, heightDp = 320)
    @Composable
    fun OnboardingPreview() {
        BasicCodeLabTheme {
            OnboardingScreen(onContinueClicked = {})
        }
    }


}

