import axios from 'axios'
import { useEffect, useState } from 'react'
import Chart from 'react-apexcharts'
import { SaleSum } from 'types/sale'
import { BASE_URL } from 'utils/requests'

type ChartData = {

    series: number[]
    labels: string[]

}

const DonutChart = () => {

    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] })

    useEffect(() => {

        axios.get(`${BASE_URL}/sales/sum-per-seller`)
            .then(response => {

                const apiData = response.data as SaleSum[]
                const apiLabels = apiData.map(data => data.sellerName)
                const apiSeries = apiData.map(data => data.sum)

                setChartData({ labels: apiLabels, series: apiSeries })

            })

    }, [])


    const options = {
        legend: {
            show: true
        }
    }

    //const mockData = {

    //    labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé'],
    //    series: [477138, 499928, 444867, 220426, 473088]

    //}


    return (
        <Chart

            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"


        />



    );
}

export default DonutChart;