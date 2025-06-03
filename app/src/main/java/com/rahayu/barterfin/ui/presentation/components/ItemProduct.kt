package com.rahayu.barterfin.ui.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahayu.barterfin.R
import com.rahayu.barterfin.ui.theme.BarterfinTheme
import com.rahayu.barterfin.ui.theme.textPrimary

@Composable
fun ItemProduct(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
    loading: Boolean = false,
    title: String,
    imageUrl: String,
    category: String,
    location: String,
    price: String,
    desc: String
) {
    Card(
        modifier = modifier.clickable(
            onClick = { onClick() }
        ),
        border = BorderStroke(1.dp, Color(0xFFE5E7EB)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            Modifier.padding(12.dp),
        ) {

            CoilLoader(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(158.dp),
                imageUrl = imageUrl,
                loading = loading
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    lineHeight = 19.sp,
                    fontWeight = FontWeight.Medium,
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(Modifier.height(4.5.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon__category),
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = stringResource(R.string.category_icon),
                )

                Spacer(Modifier.width(2.dp))

                Text(
                    text = category,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Normal,
                    ),
                    maxLines = 1,
                    lineHeight = 15.sp,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            Spacer(Modifier.height(5.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(R.drawable.maps),
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = stringResource(R.string.category_icon),
                )

                Spacer(Modifier.width(2.dp))

                Text(
                    text = location,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Normal,
                    ),
                    maxLines = 1,
                    lineHeight = 15.sp,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            Spacer(Modifier.height(8.dp))

            Text(
                text = price,

                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Normal,
                    color = textPrimary,
                )
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = desc,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF6B7280),
                    lineHeight = 14.sp,
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ButtonCustom(
                    onClick = {  },
                    modifier = Modifier.weight(1f),
                    color = MaterialTheme.colorScheme.primary,
                    contentPadding = PaddingValues(vertical = 8.dp, horizontal = 24.dp),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(R.string.barter),
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Medium,
                                color = Color.White
                            )
                        )

                        Icon(
                            painter = painterResource(R.drawable.data),
                            contentDescription = stringResource(R.string.data),
                            tint = Color.White,
                        )
                    }
                }

                Card(
                    modifier = Modifier.size(40.dp)
                        .clickable(
                            onClick ={}
                        ),
                    shape = RoundedCornerShape(500.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = stringResource(R.string.favorite_icon),
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }


            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun ShowItemProduct() {
    BarterfinTheme {
        ItemProduct(
            modifier = Modifier.fillMaxWidth(),
            title = "Sepatu Nike Air Max",
            imageUrl = "https://example.com/image.jpg",
            category = "Olahraga",
            location = "Jakarta",
            price = "Rp 500.000",
            desc = "Sepatu Nike Air Max bekas, kondisi masih bagus dan nyaman digunakan.",
        )
    }
}