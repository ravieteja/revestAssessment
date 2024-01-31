package com.example.revest.products.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.revest.common.models.ProductResponseModel
import com.example.revest.common.ui.RvImageView
import com.example.revest.common.ui.RvTextView
import com.example.revest.ui.theme.Gray
import com.example.revest.ui.theme.descriptionStyle
import com.example.revest.utils.Constants.PRODUCT_LIST_IMAGE_HEIGHT
import com.example.revest.utils.Constants.PRODUCT_LIST_IMAGE_WIDTH
import com.example.revest.utils.capitalizeWords

@Composable
fun RvProductItemView(product: ProductResponseModel, onClick: (Int) -> Unit) {
    Card(colors = CardDefaults.cardColors(containerColor = Gray),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .clickable {
                onClick.invoke(product.id ?: 0)
            }) {
        Row(modifier = Modifier.padding(8.dp)) {
            Box(
                modifier = Modifier
                    .height(PRODUCT_LIST_IMAGE_HEIGHT.dp)
                    .width(PRODUCT_LIST_IMAGE_WIDTH.dp)
                    .padding(4.dp)
            ) {
                RvImageView(
                    image = product.thumbnail ?: "",
                    imageDescription = product.title ?: "",
                    modifier = Modifier.clip(shape = RoundedCornerShape(10.dp))
                )
            }
            Box(
                modifier = Modifier
                    .weight(weight = 1f)
                    .padding(4.dp)
            ) {
                Column {
                    product.title?.let { title ->
                        RvTextView(title.capitalizeWords())
                    }
                    product.brand?.let { brand ->
                        RvTextView(brand, style = descriptionStyle.copy(fontSize = 12.sp), modifier = Modifier.padding(vertical = 2.dp))
                    }
                    product.description?.let { description ->
                        RvTextView(description, style = descriptionStyle, maxLines = 2)
                    }
                }
            }
        }
    }
}