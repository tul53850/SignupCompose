package edu.temple.signupcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import edu.temple.signupcompose.ui.theme.SignupComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUpForm("Android")
                }
            }
        }
    }
}

@Composable
fun SignUpForm(name: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        var userName by rememberSaveable { mutableStateOf("") }

        Text(
            text = "Sign Up Form!",
            modifier = modifier,
            fontSize = 28.sp
        )
        TextField(
            value = userName,
            label = {Text("Name")},
            onValueChange = {userName = it}
        )
        Button(onClick = { /*TODO*/ }) {
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SignupComposeTheme {
        SignUpForm("Bro")
    }
}