import React from 'react';
import style from './style.css';

class EventHeader extends React.Component {
	render () {

		return (
			<div className={style.header}>
				<h1 className={style.title}>
					{this.props.name}
				</h1>
				<div className={style.additionalInfo}>
					<div className={style.date}>
						{this.props.beginDate}
						{/*TODO <DateTimeDuration />*/}
					</div>
					<div className={style.capacity}>
						{this.props.capacity}
					</div>
				</div>
			</div>
		);

	}
}

export default EventHeader;