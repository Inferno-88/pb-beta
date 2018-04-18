import React from 'react';
import styles from './style.css';
import ListItem from '../ListItem/index';

class ListEvents extends React.Component {
	render () {
		let events = this.props.events.map((item) => {
			return (
				<ListItem onClick={this.props.onClick} dataId={item.id} key={item.id} {...item} />
			);
		});

		return (
			<div className={styles.listEvents}>
				<ul className={styles.list}>
					{ events }
				</ul>
			</div>
		);
	}
}

export default ListEvents;