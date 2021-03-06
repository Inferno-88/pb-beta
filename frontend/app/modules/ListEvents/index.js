import React from 'react';
import style from './style.css';
import ListItem from '../ListItem/index';

class ListEvents extends React.Component {
	render () {
		let events = this.props.events.map((item) => {
			return (
				<ListItem onClick={this.props.onClick} dataId={item.id} key={item.id} {...item} />
			);
		});

		let classNames = `${style.listEvents} ${this.props.className}`

		return (
			<div className={classNames}>
				<ul className={style.list}>
					{ events }
				</ul>
			</div>
		);
	}
}

export default ListEvents;