import React from 'react';
import ListOfEvents from './ListOfEvents/index';
import EventDescription from './EventDescription';
import { listOfEvents, detailOfEvent } from '../mockdata.js';


class Layout extends React.Component {
	constructor (props) {
		super(props);
		this.state = {
			currentEvent: null,
		};
	}

	hendlerOpenEvent (e) {
		const discr = detailOfEvent[e.currentTarget.dataset.id];
		this.setState({
			currentEvent: discr,
		});
	}

	render () {
		return (
			<div>
				<ListOfEvents events={listOfEvents} onClick={this.hendlerOpenEvent.bind(this)} />
				<EventDescription event={this.state.currentEvent} />
			</div>
		);
	}
}

export default Layout;
