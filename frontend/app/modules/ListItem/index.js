import React from 'react';
import style from './style.css';

import moment from 'moment';

class ListItem extends React.Component {

	render () {
		return (
			<li onClick={this.props.onClick} className={style.listItem} data-id={this.props.dataId}>
				<h3 className={style.name}>
					{this.props.name}
				</h3>
				<div className={style.descriptionRow}>
					<span className={style.date}>
						{moment(this.props.date).format('DD MMMM YYYY')}
					</span>
					<span className={style.peopleCount}>
						{this.props.peopleCount} чел.
					</span>
				</div>
			</li>
		);
	}
}

export default ListItem;
