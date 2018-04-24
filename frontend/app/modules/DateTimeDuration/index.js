import React from 'react';
import style from './style.css';
import moment from 'moment';


class DateTimeDuration extends React.Component {

	render () {
		const dateBegin = moment(this.props.dateTimeBegin).format('DD MMMM YYYY');
		const dateEnd = moment(this.props.dateTimeEnd).format('DD MMMM YYYY');
		const timeBegin = moment(this.props.dateTimeBegin).format('h:mm');
		const timeEnd = moment(this.props.dateTimeEnd).format('h:mm');
		const isMoreThenDay = (dateBegin === dateEnd);
		let final;

		return (
			<div>
				{dateBegin},
				c {timeBegin}
				до
				{timeEnd}

			</div>
		);

	}
}

export default DateTimeDuration;