import React, {Component} from 'react'
import axios from 'axios';
import {CartesianGrid, Legend, Line, LineChart, ResponsiveContainer, Tooltip, XAxis, YAxis} from 'recharts';

export default class StockInfo extends Component {

    constructor(props) {
        super(props);
        this.state = {
            stocks: []
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8080/api/stocks/")
            .then(response => response.data)
            .then((data) => {
                this.setState({stocks: data})
            });
    }

    render() {
        const graphData = this.state.stocks

        const renderLineChart = (
            <ResponsiveContainer width={'80%'} height={700}>
                <LineChart
                    margin={{
                        top: 5, right: 30, left: 20, bottom: 5,
                    }}
                    data={graphData}>

                    <CartesianGrid strokeDasharray="3 3"/>

                    <XAxis dataKey="date" interval={"preserveStartEnd"} minTickGap={28}/>
                    <YAxis label={{value: "Stocks price", angle: -90}}/>
                    <Tooltip/>
                    <Legend verticalAlign="top" height={36} iconSize={20}/>

                    <Line type="monotone" dataKey="Nokia" stroke="#8884d8"/>
                    <Line type="monotone" dataKey="Nordea" stroke="#82ca9d"/>
                    <Line type="monotone" dataKey="Microsoft" stroke="#f08068"/>
                    <Line type="monotone" dataKey="Telia" stroke=" #f1c46f "/>
                </LineChart>
            </ResponsiveContainer>
        )
        return (
            this.state.stocks.length === 0 ?
                <p align="center">Waiting for a response from the server</p> :
                renderLineChart
        );
    }

}