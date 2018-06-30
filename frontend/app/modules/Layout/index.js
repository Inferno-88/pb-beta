import React from 'react';
import style from './style.css';
import ListEvents from '../ListEvents/index';
import EventDescription from '../EventDescription/index';
//import { listOfEvents, detailOfEvent } from '../mockdata.js';


class Layout extends React.Component {
	constructor (props) {
		super(props);
		this.state = {
			currentEvent: null,
			listShortEvents: [],
		};
		fetch('http://localhost:8181/event/previews').then(function (res) {
			if (res.status === 200) { //TODO catch
				return res.json();
			}
		}).then(function (list) {
			this.setState({
				listShortEvents: list,
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
			<div className={style.layout}>
				<ListEvents
					className={style.listEvents}
					events={this.state.listShortEvents}
					onClick={this.hendlerOpenEvent.bind(this)}
				/>
				{this.state.currentEvent &&
					<EventDescription
						className={style.eventDescription}
						event={this.state.currentEvent}
					/>
				}
			</div>
		);
	}
}

export default Layout;
