package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card()
                }
            }
        }
    }
}

//The middle portion of the business card
//Use a box container next time
@Composable
fun Card(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize()) {    //This is just a container for all the stuff
        Box( //Background
            modifier //Remember that the order of modifier matters (slap two backgrounds together!)
                .background(Color(28, 50, 71))
                .padding(15.dp)
                .background(Color(160, 214, 217))
                .fillMaxSize()
        ) {
            Column(//UI foreground
                modifier.align(Alignment.Center)
                        .fillMaxSize()
                        .padding(16.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,


            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally

                        ){//The actual UI
                    Image(
                        painter = painterResource(R.drawable.android_logo),
                        contentDescription = stringResource(R.string.description_android_icon),
                        Modifier
                            .background(Color(65, 52, 148))
                            .size(200.dp)
                    )
                    Text(
                        text = stringResource(R.string.megabreadbox),
                        fontSize = 24.sp,
                        //color = Color(65, 52, 148) not a great color
                    )
                    Text(
                        text = stringResource(R.string.developer),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(28, 50, 71)
                    )

                }
                Column(

                ) {
                    Spacer(modifier = modifier.size(80.dp))

                    //Telepohne row
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Icon(
                            Icons.Filled.Call,
                            contentDescription = stringResource(R.string.description_phone_icon),
                            modifier.padding(end = 8.dp)


                        )
                        Text(
                            text = stringResource(R.string.phone_number),
                            fontSize = 16.sp
                        )
                    }
                    //Sharing row
                    Spacer(modifier = modifier.size(10.dp))
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Icon(
                            Icons.Filled.Share,
                            contentDescription = stringResource(R.string.description_social_media),
                            modifier.padding(end = 8.dp)


                            )
                        Text(
                            text = stringResource(R.string.social_media),
                            fontSize = 16.sp
                        )
                    }
                    //Email Row
                    Spacer(modifier = modifier.size(10.dp))
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Icon(
                            Icons.Filled.Email,
                            contentDescription = stringResource(R.string.description_email),
                            modifier.padding(end = 8.dp)


                        )
                        Text(
                            text = stringResource(R.string.breadbox_email),
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
    
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Card()
    }
}