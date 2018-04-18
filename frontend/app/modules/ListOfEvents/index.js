import React from 'react';
import styles from './style.css';
import ListItem from '../ListItem/index';

//TODO все константы стилей запихнуть в props и определить их в defaultProps

class ListOfEvents extends React.Component {

	constructor (props) {
		super(props);
		this.state = {
			showCount: props.showCount ? props.showCount : 4,
			currentPosition: 0,
		};
		this.onClickDown = this.onClickDown.bind(this);
		this.onClickUp = this.onClickUp.bind(this);
	}

	onClickUp () {
		let cur = this.state.currentPosition;
		if (cur > 0) {
			cur--;
		}
		this.setState({
			currentPosition: cur,
		});
	}

	onClickDown () {
		let cur = this.state.currentPosition;
		if (cur < this.props.events.length - this.state.showCount) {
			cur++;
		}
		this.setState({
			currentPosition: cur,
		});
	}

	render () {
		let events = this.props.events.map((item) => {
			return (
				<ListItem onClick={this.props.onClick} dataId={item.id} key={item.id} {...item} />
			);
		});

		const notShowUp = this.state.currentPosition === 0;
		const notShowDown = this.state.currentPosition === this.props.events.length - this.state.showCount;

		return (
			<div className={styles.listEvent}>
				<div className={styles.up} onClick={this.onClickUp} style={{ opacity: notShowUp ? 0 : 1 }}>^</div>
				<div className={styles.listWrapper}>
					<ul style={{ top: this.state.currentPosition * (-60) + 'px' }}>
						{ events }
					</ul>
				</div>
				<div className={styles.down} onClick={this.onClickDown} style={{ opacity: notShowDown ? 0 : 1 }}>v</div>
			</div>
		);
	}
}

export default ListOfEvents;