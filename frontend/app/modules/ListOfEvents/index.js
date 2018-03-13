import React from 'react';
import './index.css';
import ListItem from '../ListItem/index';

class ListOfEvents extends React.Component {


	render () {
		let events = this.props.events.map((item) => {
			return (
				<ListItem onClick={this.props.onClick} dataId={item.id} key={item.id} {...item} />
			);
		});

		return (
			<div className='list_of_events'>
				<ul>
					{ events }
				</ul>
			</div>
		);
	}
}

export default ListOfEvents;