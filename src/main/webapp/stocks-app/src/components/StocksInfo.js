import React, {Component} from 'react'
import axios from 'axios';
import {CartesianGrid, Legend, Line, LineChart, ResponsiveContainer, Tooltip, XAxis, YAxis} from 'recharts';
import {Dropdown, DropdownButton} from "react-bootstrap";

export default class StocksInfo extends Component {

    constructor(props) {
        super(props);
        this.state = {
            stocks: [],
            dates: ["2017-01-01", "2017-02-01", "2017-03-01", "2017-04-01", "2017-05-01", "2017-06-01", "2017-07-01",
                "2017-08-01", "2017-09-01", "2017-10-01", "2017-11-01", "2017-12-01", "2017-12-31"],
            graphData: [],
            ticks: []
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8080/api/stocks/")
            .then(response => response.data)
            .then((data) => {
                this.setState({stocks: data})
            });
    }

    showData = (param) => {
        let graph = [];
        let ticks = [];
        /*
        * Dates need to be fine-grained manually because they are irregular.
        * "+1" needed for end position because count starts from 0
        * */
        switch (param) {
            case "full":
                break;
            case "1-6":
                graph = this.state.stocks.slice(0, 181 + 1);
                ticks = this.state.dates.slice(0, 6 + 1);
                break;
            case "7-12":
                graph = this.state.stocks.slice(181, 365 + 1);
                ticks = this.state.dates.slice(6, 12 + 1);
                break;
            case "1-3":
                graph = this.state.stocks.slice(0, 90 + 1);
                ticks = this.state.dates.slice(0, 3 + 1);
                break;
            case "4-6":
                graph = this.state.stocks.slice(90, 181 + 1);
                ticks = this.state.dates.slice(3, 6 + 1);
                break;
            case "7-9":
                graph = this.state.stocks.slice(181, 273 + 1);
                ticks = this.state.dates.slice(6, 9 + 1);
                break;
            case "10-12":
                graph = this.state.stocks.slice(273, 365 + 1);
                ticks = this.state.dates.slice(9, 12 + 1);
                break;
        }

        this.setState({
            graphData: graph,
            ticks: ticks
        })
    };

    render() {
        // State changes when different time periods are selected in dropdown
        let graphData = this.state.graphData.length !== 0 ? this.state.graphData : this.state.stocks;
        let ticks = this.state.ticks.length !== 0 ? this.state.ticks : this.state.dates;

        const renderLineChart = (
            <ResponsiveContainer width={'75%'} height={500}>
                <LineChart
                    margin={{
                        top: 5, right: 30, left: 20, bottom: 5,
                    }}
                    data={graphData}>

                    <CartesianGrid strokeDasharray="3 3"/>

                    <XAxis dataKey="date" ticks={ticks}/>
                    <YAxis label={{value: "Stocks price", angle: -90}}/>
                    <Tooltip/>
                    <Legend verticalAlign="top" height={36} iconSize={20}/>

                    <Line type="monotone" dataKey="Nokia" stroke="#8884d8"/>
                    <Line type="monotone" dataKey="Nordea" stroke="#82ca9d"/>
                    <Line type="monotone" dataKey="Microsoft" stroke="#f08068"/>
                    <Line type="monotone" dataKey="Telia" stroke=" #f1c46f"/>
                </LineChart>
            </ResponsiveContainer>
        );
        return (
            <div className="m-5">
                {this.state.stocks.length === 0 ?
                    <p align="center">Waiting for a response from the server</p> : renderLineChart
                }

                <DropdownButton id="dropdown" title="Choose reporting time period">
                    <Dropdown.Item onClick={() => this.showData()}>Full year</Dropdown.Item>
                    <Dropdown.Item onClick={() => this.showData("1-6")}>First half (Jan 1 - July 1)</Dropdown.Item>
                    <Dropdown.Item onClick={() => this.showData("7-12")}>Second half (July 1 - Dec 31)</Dropdown.Item>
                    <Dropdown.Item onClick={() => this.showData("1-3")}>First quarter (Jan 1 - Apr 1)</Dropdown.Item>
                    <Dropdown.Item onClick={() => this.showData("4-6")}>Second quarter (Apr 1 - July 1)</Dropdown.Item>
                    <Dropdown.Item onClick={() => this.showData("7-9")}>Third quarter (July 1 - Oct 1)</Dropdown.Item>
                    <Dropdown.Item onClick={() => this.showData("10-12")}>Last quarter (Oct 1 - Dec 31)</Dropdown.Item>
                </DropdownButton>

            </div>

        );
    }

}