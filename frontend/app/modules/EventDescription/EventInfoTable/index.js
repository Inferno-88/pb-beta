import React from 'react';
import style from './style.css';


class EventInfoTable extends React.Component {


	render () {


		return (
			<div>
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
		);
	}
}

export default EventInfoTable;