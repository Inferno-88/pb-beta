const React = require('react');
import style from './style.css';


class EventDescription extends React.Component {


	render () {
		const ev = this.props.event;
		let classNames = `${style.eventDescription} ${this.props.className}`;

		return (
			<div className={classNames}>
				<div className={style.header}>
					{ev.name}
					{ev.capacity}
					{ev.beginDate}
					{ev.endDate}
				</div>
				<div className={style.main}>
					<div className={style.gallery}>
						<img src="http://topgun.ru/wp-content/uploads/Mira-po-pejntbolu-zavershilsya-CHempion-2014-goda-rossijskaya-pejntbol-naya-komanda-7.jpg" />
					</div>
					<div className={style.info}>
						<div className={style.infoEvent}>
							{ev.info}
						</div>
						<div className={style.infoField}>
							{JSON.stringify(ev.field)}
						</div>
						<div className={style.infoRules}>
							lala
							{ev.gameRules}
						</div>
					</div>
				</div>
				<div className={style.playersArea}>
					{JSON.stringify(ev.groupMap)}
				</div>

			</div>
		);
	}
}

export default EventDescription;