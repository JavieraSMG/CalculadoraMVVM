package cl.bootcamp.e9m5.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Title(text: String) {
    Text(
        text = text,
        fontSize = 30.sp,
        fontWeight = FontWeight.SemiBold
    )
}



@Composable
fun InputBox(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp, 10.dp)

    )
}

@Composable
fun MainButton(onClick: () -> Unit ) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp),
    )

    {
        Text(
            text = "Calcular",
            fontSize = 20.sp,
            fontWeight = FontWeight.W400,
            color = Color.DarkGray

        )
    }
}

@Composable
fun SegmentedButtonSelect() {
    val checkedList = remember { mutableStateListOf<Int>() }
    val options = listOf("Hombre", "Mujer")

    MultiChoiceSegmentedButtonRow {
        options.forEachIndexed { index, label ->

            SegmentedButton(
                modifier = Modifier.width(150.dp),
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                onCheckedChange = {
                    if (checkedList.isEmpty()) {
                        checkedList.add(index)
                    } else {
                        checkedList.clear()
                        checkedList.add(index)
                    }

                },
                checked = index in checkedList
            ) {
               Text(label)
            }
        }
    }
}

//EJERCICIO 10
@Composable
fun ResultText(result: Double) {
    Text(
        text = result.toString(),
        fontSize = 50.sp,
        fontWeight = FontWeight.SemiBold
    )
}

fun calculateBMI(weight: Double, height: Double): Double {
    val imc=weight / (height/100 * height/100)
    return kotlin.math.round(imc*10)/10.0
}



