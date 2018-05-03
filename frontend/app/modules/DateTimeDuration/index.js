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
		const isTimePeriod = (timeBegin === timeEnd);
		let finalTime;
		let finalDate;

		if (dateBegin || dateEnd) {
			finalDate = isMoreThenDay
				?
				dateBegin || dateEnd
				:
				`c ${dateBegin} по ${dateEnd}`;
		} else {
			finalDate = 'Дата еще не определена';
		}

		if (timeBegin) {
			finalTime = isTimePeriod
				?
				`начало в ${timeBegin}`
				:
				`c ${timeBegin} по ${timeEnd}`;
		}
//TODO позаботиться о пробеле
		return (
			<div>
				{finalDate},
				{finalTime}
			</div>
		);

	}
}

export default DateTimeDuration;