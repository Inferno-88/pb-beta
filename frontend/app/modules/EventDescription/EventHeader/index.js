import React from 'react';
import style from './style.css';

class EventHeader extends React.Component {
	render () {

		return (
			<div className={style.container}>
				<h1 className={style.title}>
					{this.props.name}
				</h1>
				<div className={style.additionalInfo}>
					<div className={style.date}>
						{this.props.beginDate}
						{/*TODO <DateTimeDuration
							dateTimeBegin={this.props.beginDate}
							dateTimeEnd={this.props.beginDate}
						/>*/}
					</div>
					<div className={style.capacity}>
						Армия:
						{this.props.capacity}
					</div>
				</div>
			</div>
		);

	}
}

export default EventHeader;