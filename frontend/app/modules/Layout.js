import React from 'react';
import ListOfEvents from './ListOfEvents/index';
import EventDescription from './EventDescription';
import { listOfEvents, detailOfEvent } from '../mockdata.js';


class Layout extends React.Component {
	constructor (props) {
		super(props);
		this.state = {
			currentEvent: null,
			listOfEvents: [],
		};
		fetch('http://localhost:8181/event/getAllPreview').then(function (res) {
			if (res.status === 200) { //TODO catch
				return res.json();
			}
		}).then(function (list) {
			this.setState({
				listOfEvents: list,
			});
		}.bind(this));
	}

	hendlerOpenEvent (e) {
		const id = e.currentTarget.dataset.id;
		fetch(`http://localhost:8181/event/get/${id}`).then(function (res) {
			if (res.status === 200) { //TODO catch
				return res.json();
			}
		}).then(function (event) {
			this.setState({
				currentEvent: event,
			});
		}.bind(this));
	}

	render () {
		return (
			<div>
				<ListOfEvents events={this.state.listOfEvents} onClick={this.hendlerOpenEvent.bind(this)} />
				<EventDescription event={this.state.currentEvent} />
			</div>
		);
	}
}

export default Layout;
