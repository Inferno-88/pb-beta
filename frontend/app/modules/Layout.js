import React from 'react';
//import ListOfEvents from './ListOfEvents/index';
import ListEvents from './ListEvents/index';
import EventDescription from './EventDescription';
//import { listOfEvents, detailOfEvent } from '../mockdata.js';


class Layout extends React.Component {
	constructor (props) {
		super(props);
		this.state = {
			currentEvent: null,
			listStortEvents: [],
		};
		fetch('http://localhost:8181/event/previews').then(function (res) {
			if (res.status === 200) { //TODO catch
				return res.json();
			}
		}).then(function (list) {
			this.setState({
				listStortEvents: list,
			});
		}.bind(this));
	}

	hendlerOpenEvent (e) {
		const id = e.currentTarget.dataset.id;
		fetch(`http://localhost:8181/event/events/${id}`).then(function (res) {
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
				<ListEvents events={this.state.listStortEvents} onClick={this.hendlerOpenEvent.bind(this)} />
				{this.state.currentEvent &&
					<EventDescription event={this.state.currentEvent} />
				}
			</div>
		);
	}
}

export default Layout;
