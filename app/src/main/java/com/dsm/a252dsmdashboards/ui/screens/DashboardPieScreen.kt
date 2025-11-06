package com.dsm.a252dsmdashboards.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dsm.a252dsmdashboards.data.model.NpersonasXTipoDocumento
import com.dsm.a252dsmdashboards.utils.Utils
import com.github.tehras.charts.piechart.PieChart
import com.github.tehras.charts.piechart.PieChartData
import com.github.tehras.charts.piechart.renderer.SimpleSliceDrawer

@Composable
fun PieScreen(data: List<NpersonasXTipoDocumento>){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text="Grafico Pie")
        Pie(data)
    }
}
@Composable
fun Pie(data: List<NpersonasXTipoDocumento>){
    val datos = data
    val slices = ArrayList<PieChartData.Slice>()
    val total = datos.sumOf { it.cantidad.toDouble() }.toFloat()

    datos.mapIndexed{index, datos ->
        slices.add(
            PieChartData.Slice(
                value = datos.cantidad.toFloat(),
                color = Utils().colorAleatorio()
            )
        )
    }
    Column(
        modifier = Modifier
            .padding(2.dp,80.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        PieChart(
            modifier = Modifier
                .padding(30.dp,80.dp)
                .height(300.dp),
            sliceDrawer = SimpleSliceDrawer(
                sliceThickness = 100f
            ),
            pieChartData = PieChartData(
                slices = slices
            )
        )
        Spacer(modifier = Modifier.height(1.dp))
        //Leyenda del Pie
        datos.forEach{
            val porcentaje= (it.cantidad/total*100).toInt()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ){
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .background(Utils().colorAleatorio(),
                                    shape = CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("${it.descripcion}: ${it. cantidad} (${porcentaje}%)")
            }
        }
    }
}

