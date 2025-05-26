package alejandro.barrera.randomusermultiplatform

import alejandro.barrera.randomusermultiplatform.presentation.ExploreViewModel
import alejandro.barrera.randomusermultiplatform.presentation.model.UserVo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import org.koin.android.ext.android.getKoin
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val koin = getKoin()
        val viewModel: ExploreViewModel = koin.get()

        setContent {
            ExploreScreen(viewModel)
        }
    }
}

@Composable
fun ExploreScreen(viewModel: ExploreViewModel) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) { viewModel.load() }

    when {
        state.isLoading -> CircularProgressIndicator()
        state.error != null -> Text("Error: ${state.error}")
        else -> SuccessExploreScreen(users = state.users)
    }
}

@Composable
private fun SuccessExploreScreen(
    users: List<UserVo>,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(users) { user ->
                UserItem(
                    user = user,
                    onItemClick = {}
                )
            }
        }
    }
}

@Composable
fun UserItem(
    user: UserVo,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(start = 16.dp)
            .clickable { onItemClick() }
    ) {
        UserContactRow(user = user)
        HorizontalDivider(
            modifier = Modifier.padding(
                top = 16.dp,
                start = 64.dp
            )
        )
    }
}

@Composable
fun UserContactRow(
    user: UserVo,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        Icon(
            imageVector = Icons.Filled.Face,
            contentDescription = "Smily face",
            modifier = Modifier.size(64.dp)
        )
        ContentRow(user = user)
    }
}

@Composable
fun ContentRow(
    user: UserVo,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.height(32.dp)
        ) {
            Text(text = "Nombre: ${user.name}")
            Text(text = "Email: ${user.name}")
        }
    }
}