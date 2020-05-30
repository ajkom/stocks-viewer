import React, {Component} from 'react'
import axios from 'axios';


export default class StockInfo extends Component {

    constructor(props) {
        super(props);
        this.state = {
            stocks: []
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8080/api/stockInfo")
            .then(response => response.data)
            .then((data) => {
                this.setState({stocks: data})
            });
            // .then(response => console.log(response.data));
    }

    render() {
        return (
            <p>{this.state.stocks.length}</p>

        );
    }

}