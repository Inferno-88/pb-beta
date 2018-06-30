import React from 'react';
import style from './style.css';


class EventInfoTable extends React.Component {


	render () {
		const {info, field, gameRules} = this.props;
// TODO сделать нормальные вкладки
		return (
			<div className={style.eventInfoTable}>
				<div className={style.tabArea}>
					<div className={style.tab}>
						Инфо
					</div>
					<div className={style.tabContent}>
						{info}
					</div>
				</div>
				<div className={style.tabArea}>
					<div className={style.tab}>
						Field
					</div>
					<div className={style.tabContent}>
						{JSON.stringify(field)}
					</div>
				</div>
				<div className={style.tabArea}>
					<div className={style.tab}>
						GameRULES
					</div>
					<div className={style.tabContent}>
						lala
						{gameRules}
					</div>
				</div>
			</div>
		);
	}
}

export default EventInfoTable;