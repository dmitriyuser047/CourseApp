package com.example.course.presentation.start


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.course.R
import com.example.course.presentation.register.RegisterScreen
import com.example.course.route.ScreenKey


@Composable
fun StartScreen(navController: NavHostController, viewModel: StartViewModel = hiltViewModel()) {
    InfoCourse(
        onClick = { navController.navigate(ScreenKey.RegisterScreen) }
    )
}

@Composable
fun InfoCourse(
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(color = colorResource(R.color.background)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    stringResource(R.string.startInfoCource),
                    modifier = Modifier.padding(bottom = 50.dp, start = 20.dp, end = 20.dp),
                    color = Color.White,
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 36.sp
                )
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.start_courses),
                    contentDescription = "startImageCourses",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
            }
        }
        Button(
            onClick = { onClick() },
            modifier = Modifier
                .padding(bottom = 50.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = colorResource(R.color.green_start)
            ),
        ) {
            Text(
                stringResource(R.string.start_button_text)
            )
        }
    }

}