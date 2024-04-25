package edu.temple.signupcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
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
        var userEmail by rememberSaveable { mutableStateOf("") }
        var age by rememberSaveable { mutableStateOf("") }
        var ct = LocalContext.current

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
        TextField(
            value = userEmail,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = {Text("Email")},
            onValueChange = {userEmail = it}
        )
        TextField(
            value = age,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = {Text("Age")},
            onValueChange = {age = it}
        )
        Button(onClick = {
            val message : String = if(userName.isNotBlank()){
                "Thank you $userName!!!!"
            } else{
                "COMPLETE FORM BRO"
            }
            Toast.makeText(ct, message, Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Submit")
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