import React from 'react';
import style from './style.css';

class ListItem extends React.Component {

	render () {
		return (
			<li onClick={this.props.onClick} className={style.listItem} data-id={this.props.dataId}>
				<h3 className={style.name}>
					{this.props.name}
				</h3>
				<div className='b-list_item__description'>
					<span className='b-list_item__description__date'>
						{this.props.date}
					</span>
					<span className='b-list_item__description__count'>
						{this.props.peopleCount}
					</span>
				</div>
			</li>
		);
	}
}

export default ListItem;
